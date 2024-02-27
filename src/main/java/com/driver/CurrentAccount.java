package com.driver;
import java.util.HashMap;
import java.util.Map;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        if(balance<getMinBalance()){
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        if (!isValidLicenseId(tradeLicenseId)) {
            throw new Exception("Valid License can not be generated");
        }
        System.out.println(tradeLicenseId);
    }

    private boolean isValidLicenseId(String id) {
        char[] idChars = id.toCharArray();
        Map<Character, Integer> charCount = new HashMap<>();

        // Count occurrences of each character
        for (char c : idChars) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Check if there is any character that occurs more than half of the total length
        int halfLength = idChars.length / 2;
        for (char c : charCount.keySet()) {
            if (charCount.get(c) > halfLength) {
                return false;
            }
        }
        return true;
    }

    public String rearrangeLicenseId() throws Exception {
        validateLicenseId(); // Check if the current ID is valid

        char[] idChars = tradeLicenseId.toCharArray();
        StringBuilder rearrangedId = new StringBuilder();

        // Rearrange the characters to create a valid license ID
        rearrangedId.append(idChars[0]);
        for (int i = 2; i < idChars.length; i += 2) {
            rearrangedId.append(idChars[i]);
        }
        for (int i = 1; i < idChars.length; i += 2) {
            rearrangedId.append(idChars[i]);
        }

        return rearrangedId.toString();
    }

}
