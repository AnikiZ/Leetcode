/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-13 00:50:18
 * @LastEditTime: 2022-11-13 01:02:59
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Concurrency/WebCrawlerMultithreaded_1242.java
 */
package Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class WebCrawlerMultithreaded_1242 {

    // This is the HtmlParser's API interface.
    // You should not implement it, or speculate about its implementation
    interface HtmlParser {
        public List<String> getUrls(String url);
    }
 
    class Solution {
        ConcurrentHashMap<String, Boolean>M = new ConcurrentHashMap<>();//安全的hashmap，去重
        String rootHostName;
        List<String> ans = new ArrayList<>();
        HtmlParser htmlParser;
        // 继承线程
        class Task extends Thread {
            public String url;
            public Task(String url) {
                this.url = url;

            }
            @Override
            public void run() {
                List<Task> subtasks = new ArrayList<>();
                List<String>nexturls = htmlParser.getUrls(url);//抓取一个url下面的所有url
                for (String nexturl : nexturls) {
                    if (!rootHostName.equals(GetHostName(nexturl))) {
                        continue;
                    }
                    if (M.putIfAbsent(nexturl, Boolean.TRUE)!=null) {
                        continue;
                    }
                    
                    // M.put(nexturl, Boolean.TRUE);
                    ans.add(nexturl);

                    Task subTask = new Task(nexturl);
                    subtasks.add(subTask);
                    subTask.start();
                }
                for (Task task:subtasks) {
                    try {
                        task.join();
                    } catch(InterruptedException e) {
                        e.printStackTrace();

                    }
                }
            }
        }
        public static String GetHostName(String url) {
            final int start = 7;
            int end = url.indexOf('/', start);
            if (end == -1) {
                end = url.length();
            }
            return url.substring(start, end);
        }
        // public static String;
        public List<String> crawl(String startUrl, HtmlParser htmlParser) {
            this.rootHostName = GetHostName(startUrl);
            this.htmlParser = htmlParser;
            M.put(startUrl,Boolean.TRUE);
            ans.add(startUrl);
            Thread work = new Task(startUrl);
            work.start();
            try {
                work.join();
            }catch(InterruptedException e) {
                        e.printStackTrace();

            }
            return ans;
        }
    }
}
