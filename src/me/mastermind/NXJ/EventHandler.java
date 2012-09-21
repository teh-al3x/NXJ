/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.mastermind.NXJ;

import lejos.nxt.Motor;
import lejos.util.Delay;

/**
 *
 * @author alex
 */
public class EventHandler {
    
    public static String event = "none";
    
    public static Boolean eventHandler(int data) {
        switch (data) {
            case 0:
                Motor.A.stop(true);
                Motor.C.stop();
                RemoteReceiver.state = event = "Standing";
                return true;
            case 10:
                Motor.A.backward();
                Motor.C.backward();
                RemoteReceiver.state = event = "Backward";
                return true;
            case 20:
                Motor.A.forward();
                Motor.C.forward();
                RemoteReceiver.state = event = "Forward";
                return true;
            case 30:
                if (RemoteReceiver.motorSpeed != RemoteReceiver.minSpeed) {
                    RemoteReceiver.motorSpeed -= 10;
                    Motor.A.setSpeed(RemoteReceiver.motorSpeed);
                    Motor.C.setSpeed(RemoteReceiver.motorSpeed);
                }
                event = "SpeedDown";
                return true;
            case 40:
                if (RemoteReceiver.motorSpeed != RemoteReceiver.maxSpeed) {
                    RemoteReceiver.motorSpeed += 10;
                    Motor.A.setSpeed(RemoteReceiver.motorSpeed);
                    Motor.C.setSpeed(RemoteReceiver.motorSpeed);
                }
                event = "SpeedUp";
                return true;
            case 255:
                DisplayHandler.drawBye();
                Delay.msDelay(1000);
                return false;
            default:
                event = "Unknown";
                return true;
        }
    }
}