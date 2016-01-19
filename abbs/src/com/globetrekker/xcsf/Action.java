package com.globetrekker.xcsf;
/**
 * @author    chengen
 * @version   XCSF 1.0
 * @since     JDK1.8
 */
public class Action {
   public enum ActionType {
        buy, sell, hold;
    }
   public String objective;
   public ActionType action;
}
