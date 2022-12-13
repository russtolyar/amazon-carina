package com.solvd.carina.amazon.services;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Locale;

public class CheckMethods {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static final String GOOD_DESIGN_LOCATOR = "//*[@id='nav-main']";

    @FindBy(xpath = "//*[@id='nav-main']")
    ExtendedWebElement goodDesignLocator;


    /**
     * Verifying if Any element of 'whatList' present in All elements of 'whereList' up to element number 'numElementsToCheck'
     *
     * @param whereList
     * @param numElementsToCheck
     * @param whatList
     * @return
     */
    public static boolean isElementsPresentInList(List<String> whereList, int numElementsToCheck, List<String> whatList) {

        if (whereList.isEmpty()) {
            LOGGER.error("WHERE LIST IS EMPTY!))))");
            return false;
        }
        int countPresent = 0;
        for (int i = 0; i < numElementsToCheck; i++) {
            boolean elOfWhatPresentInElOfWhere = false;

            for (int j = 0; j < whatList.size() - 1; j++) {
                String a = whereList.get(i).toLowerCase(Locale.ROOT);
                String signdisc = whatList.get(j);
                if (!a.contains(signdisc)) {
                    continue;
                } else {
                    elOfWhatPresentInElOfWhere = true;
                    countPresent++;
                    break;
                }
            }
        }
        return countPresent == numElementsToCheck;
    }

    /**
     * Verifying if element 'whatS' present in All elements of 'whereList'
     *
     * @param whereList
     * @param whatS
     * @return
     */
    public static boolean isStringPresentInList(List<String> whereList, String whatS) {
        boolean isPresent = false;

        for (String s : whereList) {
            if (s.toLowerCase(Locale.ROOT).contains(whatS)) {
                isPresent = true;
            } else {
                return isPresent;
            }
        }
        return isPresent;
    }

    /**
     * Verifying if ALL element of 'whatArr' present in All elements of 'whereList'
     *
     * @param whereList
     * @param whatArr
     * @return
     */
    public static boolean areAllElementsContainAllElements(List<String> whereList, String[] whatArr) {
        boolean whereListContainWhatArrEl = false;
//        for (String s : whereList) {
//            for (int i = 0; i < whatArr.length; i++) {
//                if (s.toLowerCase(Locale.ROOT).contains(whatArr[i].toLowerCase(Locale.ROOT))) {

        for (int s = 0; s < 4; s++) {
            for (int i = 0; i < whatArr.length; i++) {
                if (whereList.get(s).toLowerCase(Locale.ROOT).contains(whatArr[i].toLowerCase(Locale.ROOT))) {


                    whereListContainWhatArrEl = true;
                    continue;
                } else {
                    return whereListContainWhatArrEl;
                }
            }
        }
        return whereListContainWhatArrEl;
    }
}