
#include "ReverseString.cpp"
#include <cassert>
#include <cstring>
#include <cstdio>

void should_return_same_string_when_input_is_empty(){
    char str[] = "";
    SolutionReverseString solution;
    solution.reverse(str);
    assert(strcmp(str, "") == 0);   
}

void should_return_same_string_when_input_is_a_single_character(){
    char str[] = "a";
    SolutionReverseString solution;
    solution.reverse(str);
    assert(strcmp(str, "a") == 0);   
}

void should_return_reversed_string_when_input_is_a_two_characters(){
    char str[] = "ab";
    SolutionReverseString solution;
    solution.reverse(str);
    assert(strcmp(str, "ba") == 0);   
}

void should_return_reversed_string_when_third_char_same_as_first(){
    char str[] = "aba";
    SolutionReverseString solution;
    solution.reverse(str);
    assert(strcmp(str, "aba") == 0);
}

void should_return_reversed_string_when_there_is_no_duplicate(){
    char str[] = "abcdefghijklmnopqrstuvwxyz";
    SolutionReverseString solution;
    solution.reverse(str);
    assert(strcmp(str, "zyxwvutsrqponmlkjihgfedcba") == 0);
}

int main(int argc, char const *argv[])
{
    printf("should_return_same_string_when_input_is_empty\n");
    should_return_same_string_when_input_is_empty();

    printf("should_return_same_string_when_input_is_a_single_character\n");
    should_return_same_string_when_input_is_a_single_character();
    
    printf("should_return_reversed_string_when_input_is_a_two_characters\n");
    should_return_reversed_string_when_input_is_a_two_characters();

    printf("should_return_reversed_string_when_third_char_same_as_first\n");
    should_return_reversed_string_when_third_char_same_as_first();

    printf("should_return_reversed_string_when_there_is_no_duplicate\n");
    should_return_reversed_string_when_there_is_no_duplicate();

    return 0;
}