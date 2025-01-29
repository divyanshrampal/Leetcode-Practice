class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == 'M'){
                ans += 1000;
            }
            else if(ch == 'D'){
                ans += 500;
            }
            else if(ch == 'V'){
                ans += 5;
            }
            else if(ch == 'L'){
                ans += 50;
            }
            else if(ch == 'I'){
                if(i+1 < n && s.charAt(i+1) == 'V'){
                    ans += 4;
                    i++;
                }
                else if(i+1 < n && s.charAt(i+1) == 'X'){
                    ans += 9;
                    i++;
                }
                else{
                    ans += 1;
                }
            }
            else if(ch == 'X'){
                if(i+1 < n && s.charAt(i+1) == 'L'){
                    ans += 40;
                    i++;
                }
                else if(i+1 < n && s.charAt(i+1) == 'C'){
                    ans += 90;
                    i++;
                }
                else{
                    ans += 10;
                }
            }

            else if(ch == 'C'){
                if(i+1 < n && s.charAt(i+1) == 'D'){
                    ans += 400;
                    i++;
                }
                else if(i+1 < n && s.charAt(i+1) == 'M'){
                    ans += 900;
                    i++;
                }
                else{
                    ans += 100;
                }
            }
        }

        return ans;
    }
}