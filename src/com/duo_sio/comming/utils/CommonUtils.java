/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duo_sio.comming.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author DUO SIO
 */
public class CommonUtils {
    public static String getFormattedPrice(int value){
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        symbols.setGroupingSeparator('.');
        symbols.setMonetaryDecimalSeparator(',');
        formatter.setDecimalFormatSymbols(symbols);
        return "Rp"+formatter.format(value);        
        
//        return NumberFormat.getIntegerInstance(getLocale()).format(value);
    }
}
