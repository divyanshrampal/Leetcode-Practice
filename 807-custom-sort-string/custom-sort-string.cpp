class Solution {
public:
    string customSortString(string order, string s) {
        unordered_map<char, int> mapOfS;
        string result;
        
        for(auto charOfS: s) mapOfS[charOfS]++;

        for(auto charOfOrder: order){
            if(mapOfS.find(charOfOrder) != mapOfS.end()){
                string s(mapOfS[charOfOrder], charOfOrder);
                result += s;
                mapOfS.erase(charOfOrder);
            }
        } 

        for(auto entry: mapOfS){
            string s(entry.second, entry.first);
            result+=s;
        }

        return result;
    }
};