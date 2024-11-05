
#include "ReverseStringInPlace.cpp"
#include <cassert>
#include <cstring>
#include <cstdio>

void should_return_same_string_when_input_is_empty_in_place(){
    char str[] = "";
    SolutionReverseStringInPlace solution;
    solution.reverse(str);
    assert(strcmp(str, "") == 0);   
}

void should_return_same_string_when_input_is_a_single_character_in_place(){
    char str[] = "a";
    SolutionReverseStringInPlace solution;
    solution.reverse(str);
    assert(strcmp(str, "a") == 0);   
}

void should_return_reversed_string_when_input_is_a_two_characters_in_place(){
    char str[] = "ab";
    SolutionReverseStringInPlace solution;
    solution.reverse(str);
    assert(strcmp(str, "ba") == 0);   
}

void should_return_reversed_string_when_third_char_same_as_first_in_place(){
    char str[] = "aba";
    SolutionReverseStringInPlace solution;
    solution.reverse(str);
    assert(strcmp(str, "aba") == 0);
}

void should_return_reversed_string_when_there_is_no_duplicate_in_place(){
    char str[] = "abcdefghijklmnopqrstuvwxyz";
    SolutionReverseStringInPlace solution;
    solution.reverse(str);
    assert(strcmp(str, "zyxwvutsrqponmlkjihgfedcba") == 0);
}

int mainInPlaceTests(int argc, char const *argv[])
{
    printf("should_return_same_string_when_input_is_empty");
    should_return_same_string_when_input_is_empty_in_place();
    printf("\t PASSED");

    printf("should_return_same_string_when_input_is_a_single_character\n");
    should_return_same_string_when_input_is_a_single_character_in_place();
    printf("\t PASSED");

    printf("should_return_reversed_string_when_input_is_a_two_characters\n");
    should_return_reversed_string_when_input_is_a_two_characters_in_place();
    printf("\t PASSED");
    
    printf("should_return_reversed_string_when_third_char_same_as_first\n");
    should_return_reversed_string_when_third_char_same_as_first_in_place();
    printf("\t PASSED");

    printf("should_return_reversed_string_when_there_is_no_duplicate\n");
    should_return_reversed_string_when_there_is_no_duplicate_in_place();
    printf("\t PASSED");
    
    return 0;
}