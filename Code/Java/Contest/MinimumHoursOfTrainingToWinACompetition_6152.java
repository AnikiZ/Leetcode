/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-21 00:00:36
 * @LastEditTime: 2022-08-21 00:14:30
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Contest/MinimumHoursOfTrainingToWinACompetition_6152.java
 */
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-20 23:55:14
 * @LastEditTime: 2022-08-20 23:55:14
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Contest/8.20/MinimumHoursOfTrainingToWinACompetition_6152.java
 */
package Contest;

public class MinimumHoursOfTrainingToWinACompetition_6152 {
    class Solution {
        public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
            int ans = 0;
            int n = energy.length;
            for (int i = 0; i < n; i++) {
                if (initialEnergy <= energy[i]) {
                    ans += energy[i] - initialEnergy + 1;
                    // 别忘了！
                    initialEnergy = energy[i] + 1;
                }
                if (initialExperience <= experience[i]) {
                    ans += experience[i] - initialExperience + 1;
                    // 别忘了！
                    initialExperience = experience[i] + 1;
                }
                initialEnergy -= energy[i];
                initialExperience += experience[i];
            }
            return ans;
        }
    }
}
