class Solution {
    public String removeDigit(String number, char digit) {
        String maxNumber = "";
        
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i) == digit){
                String newNumber = number.substring(0, i) + number.substring(i + 1);
                if (maxNumber.isEmpty() || newNumber.compareTo(maxNumber) > 0) {
                    maxNumber = newNumber;
                }
            }
        }
        
        return maxNumber;
    }
}
