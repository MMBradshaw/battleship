/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

/**
 *
 * @author mBradshaw
 */
class BattleshipsError {
    
public static Object displayError(Object object) {
        String message = (String) object;
        System.out.println("\t??????????????????????????????????????????????????????????????????????????????");
        System.out.println("\tSORRY TRY AGAIN: ERROR: " + message);
        System.out.println("\t???????????????????????????????????????????????????????????????????????????????");
        return null;
    }
    
}
