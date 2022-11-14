/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-13 01:09:46
 * @LastEditTime: 2022-11-13 01:11:43
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Concurrency/TrafficLightControlledIntersection_1279.java
 */
package Concurrency;

import java.util.concurrent.Semaphore;

public class TrafficLightControlledIntersection_1279 {
    class TrafficLight {
        public Semaphore sema;
        public boolean road1;
        public boolean road2;
        public TrafficLight() {
            this.sema = new Semaphore(1,  true);
            road1 = true;
            road2 = false;
        }
        
        public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection 
        ) {
            try {
                this.sema.acquire();
                //配置三种可行
                if (roadId == 1 && road1 || roadId == 2 && road2 ) {
                    crossCar.run();
                }else if(roadId == 1 && !road1) {
                    turnGreen.run();
                    road1 = true;
                    road2 = false;
                    crossCar.run();
    
                } else if(roadId == 2 && !road2) {
                    turnGreen.run();
                    road1 = false;
                    road2 = true;
                    crossCar.run();
                }
            }catch(InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.sema.release();
    
            }
            
        }
    }
}
