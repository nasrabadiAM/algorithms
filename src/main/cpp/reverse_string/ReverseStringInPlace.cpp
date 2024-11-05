#include <stack>

/**
 * Implement a function void reverse(char* str) in c or c++ which reverses
 * a null-terminated string
 * time complexity: O(n)
 * implementation time: 10 min 
 */

class SolutionReverseStringInPlace {
public:
    void reverse(char* str){
        int count = 0;
        while (str!='\0')
        {
            count++;
        }
        for (int i = 0; i < count; i++)
        {
            char tmp = str[i];
            str[i] = str[count-i];
            str[count-i] = tmp;
        }
    }
};
