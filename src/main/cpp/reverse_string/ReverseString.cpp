#include <stack>

/**
 * Implement a function void reverse(char* str) in c or c++ which reverses
 * a null-terminated string
 * time complexity: O(n)
 * implementation time: 1h 
 */

class SolutionReverseString {
public:
    void reverse(char* str){
        int i = 0;
        std::stack<char> stack;
        while (str[i] != '\0') {
            char tmp = str[i];
            stack.push(tmp);
            str[i] = tmp;
            i++;
        }
        i = 0;
        while(!stack.empty()) {
            char tmp = stack.top();
            stack.pop();
            str[i] = tmp;
            i++;
        }
    }
};
