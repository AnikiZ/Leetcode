import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExternalSort {
    private static final int CHUNK_SIZE = 100_000; // 根据内存大小调整
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";
    private static final int THREADS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws IOException, InterruptedException {
        List<File> sortedFiles = splitAndSort(INPUT_FILE);
        mergeSortedFiles(sortedFiles, OUTPUT_FILE);
    }

    private static List<File> splitAndSort(String inputFile) throws IOException, InterruptedException {
        List<File> sortedFiles = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            List<Long> numbers = new ArrayList<>(CHUNK_SIZE);

            while ((line = reader.readLine()) != null) {
                numbers.add(Long.parseLong(line));

                if (numbers.size() == CHUNK_SIZE) {
                    File tmpFile = File.createTempFile("temp", ".txt");
                    tmpFile.deleteOnExit();
                    sortedFiles.add(tmpFile);
                    executorService.execute(new SortAndSaveTask(numbers, tmpFile.getPath()));
                    numbers = new ArrayList<>(CHUNK_SIZE);
                }
            }

            if (!numbers.isEmpty()) {
                File tmpFile = File.createTempFile("temp", ".txt");
                tmpFile.deleteOnExit();
                sortedFiles.add(tmpFile);
                executorService.execute(new SortAndSaveTask(numbers, tmpFile.getPath()));
            }
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

        return sortedFiles;
    }

    private static void mergeSortedFiles(List<File> files, String outputFile) throws IOException {
        PriorityQueue<BufferedReaderWrapper> queue = new PriorityQueue<>();
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        try {
            for (File file : files) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedReaderWrapper wrapper = new BufferedReaderWrapper(reader);
                wrapper.readNext();
                queue.add(wrapper);
            }

            while (!queue.isEmpty()) {
                BufferedReaderWrapper wrapper = queue.poll();
                writer.write(String.valueOf(wrapper.currentValue));
                writer.newLine();

                if (wrapper.readNext()) {
                    queue.add(wrapper);
                }
            }
        } finally {
            for (BufferedReaderWrapper wrapper : queue) {
                wrapper.reader.close();
            }
            writer.close();
        }
    }

    static class SortAndSaveTask implements Runnable {
        private final List<Long> numbers;
        private final String outputFile;

        public SortAndSaveTask(List<Long> numbers, String outputFile) {
            this.numbers = numbers;
            this.outputFile = outputFile;
        }

        @Override
        public void run() {
            numbers.sort(Long::compare);
            try {
                saveToFile(numbers, outputFile);
            } catch (IOException e) {
                System.err.println("Error saving sorted chunk to file: " + outputFile);
                e.printStackTrace();
            }
        }

        private void saveToFile(List<Long> numbers, String outputFile) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (Long number : numbers) {
                    writer.write(String.valueOf(number));
                    writer.newLine();
                }
            }
        }
    }

    static class BufferedReaderWrapper implements Comparable<BufferedReaderWrapper> {
        public final BufferedReader reader;
        public Long currentValue;

        public BufferedReaderWrapper(BufferedReader reader) {
            this.reader = reader;
        }

        public boolean readNext() throws IOException {
            String line = reader.readLine();
            if (line == null) {
                return false;
            }
            currentValue = Long.parseLong(line);
            return true;
        }

        @Override
        public int compareTo(BufferedReaderWrapper other) {
            return Long.compare(currentValue, other.currentValue);
        }
    }
}

