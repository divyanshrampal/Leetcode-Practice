class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("UP", 1);
        map.put("DOWN", 2);
        map.put("LEFT", 3);
        map.put("RIGHT", 4);
        
        int result = 0;
        int row = 0;
        int col = 0;
        
        for(String command : commands){
            int value = map.get(command);
            
            switch(value){
                case 1 : row -= 1;
                         break;
                case 2 : row += 1;
                         break;
                case 3 : col -= 1;
                         break;
                case 4 : col += 1;
                         break;
            }
            
            result = (row*n) + col;

        }
        
        return result;
        
    }
}