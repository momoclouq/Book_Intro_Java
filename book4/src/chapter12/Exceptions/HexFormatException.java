/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12.Exceptions;

/**
 *
 * @author cis2mye
 */
public class HexFormatException extends Exception{
    public HexFormatException(){
        super("This is not hex!");
    }
}
