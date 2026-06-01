
import java.util.Arrays;

class Lab5{  
  
   /**
   * Do not change the main method.
   */
  public static void main(String[] args){
    System.out.println("**************************");    
    System.out.println("Testing the method howManyDigits");
    System.out.println(howManyDigits("nBdj^19hb1^3j"));
    System.out.println(howManyDigits("Elementary data structures"));
    System.out.println(howManyDigits("H1Lolow2World !"));
    System.out.println(howManyDigits("")); 
    
    System.out.println("**************************");    
    System.out.println("Testing the method containsCapital");
    System.out.println(containsCapital("uteP"));
    System.out.println(containsCapital("abcba")); 
    System.out.println(containsCapital("12#(1)b!nc!"));
    System.out.println(containsCapital("12#(1)b!nc!X"));
    
    System.out.println("**************************");    
    System.out.println("Checking for Palindromes:");
    System.out.println(checkPalindrome("zxcxz"));
    System.out.println(checkPalindrome("zxccxz"));
    System.out.println(checkPalindrome("1xccxx1"));

    System.out.println("**************************");    
    System.out.println("Reversing a given string:");
    System.out.println(reverseOrder("POT"));
    System.out.println(reverseOrder("ZIGZAG"));
    System.out.println(reverseOrder("PETU"));
    
    System.out.println("**************************");
    System.out.println("Testing returnSubstring");
    System.out.println(returnSubstring("Apple", "aPLe"));
    System.out.println(returnSubstring(
          "Th#is#,% is, a( test.", "#,%()"));
    System.out.println(returnSubstring(
          "12T2o1 2b11e2, 1o2r3 @n12#o7t9 ^t%2o1 b*7#e.", 
          "1234567890@%#^*+"));
    System.out.println(returnSubstring(
          "What's in a name? A rose by any other name would smell as sweet.", 
          "aeiouAEIOU"));
    
    System.out.println("**************************");
    System.out.println("Testing recursive binary search with array of int.");
    int[] arr0 = {12, 19, 21, 25, 27, 28, 30, 33, 34, 48};
    int key = 29;
    int pos = binaryNumSearch(arr0, key, 0, arr0.length-1);
    System.out.println(key+" is in location "+pos);

    int[] arr1 = {13, 15, 19, 41, 45, 54, 60, 64, 66, 71};
    key = 15;
    pos = binaryNumSearch(arr1, key, 0, arr1.length-1);
    System.out.println(key+" is in location "+pos);

    int[] arr2 = {11, 12, 18, 32, 33, 37, 38, 39, 54, 56};
    key = 56;
    pos = binaryNumSearch(arr2, key, 0, arr2.length-1);
    System.out.println(key+" is in location "+pos);


    System.out.println("**************************");
    System.out.println("Testing recursive binary search with String.");
    String str="nMnxbShfg#iNfhT";
    str=getSortedString(str);
    char ch = 'n';    
    int loc =binaryCharSearch(str, ch, 0, str.length()-1);    
    System.out.println(ch+" in "+str+" is found in location "+loc);
    
    str=getSortedString("fantastic");
    ch = 'T';    
    loc =binaryCharSearch(str, ch, 0, str.length()-1);    
    System.out.println(ch+" in "+str+" is found in location "+loc);    
    str=getSortedString("Global warming");
    ch = ' ';    
    loc =binaryCharSearch(str, ch, 0, str.length()-1);    
    System.out.println(ch+" in "+str+" is found in location "+loc);        
    
    str=getSortedString("abcdxyz");
    ch = 'x';    
    loc =binaryCharSearch(str, ch, 0, str.length()-1);    
    System.out.println(ch+" in "+str+" is found in location "+loc);            
    
  }
  
  /**
   * Do not change this method.
   */
  static String getSortedString(String st){
        // Construct an array of characters
        char arr[] = st.toCharArray();
 
        // Sort the array using Java's sorting facility.
        Arrays.sort(arr);
 
        // convert the array of characters to a String
        // and return it.
        return new String(arr);
  }
  
  
  /**
   * Write a recursive method to return number of digits a string
   * contains. 
   * @param str
   * @return 
   */
  static int howManyDigits(String str){
      if(str.isEmpty()){//does this because if you do str==null it wont return if it is an empty string
        return 0;
      }
      int count = 0;
      if(Character.isDigit(str.charAt(0))){//checks if the first letter is a digit
        count++;
      }

      return count + howManyDigits(str.substring(1));//this removes the letter or char you checked at 0
  }
  
  /**
   * Write a recursive method to find if a string contains
   * any capital letter (any letter between A-Z).
   * @param str
   * @return 
   */
  static boolean containsCapital(String str){
      if(str.isEmpty()){//if string is empty or it goes through the entire string and no cappital
        return false;
      }
      if(Character.isUpperCase(str.charAt(0))){//checks if the first string is a capital
        return true;
      }
      return containsCapital(str.substring(1));//if not a capital it removes the first letter and continues
  }
  
  /** 
   * Write a recursive method to check if a given string
   * is a Palindrome.
   * @param str
   * @return 
   */
  static boolean checkPalindrome(String str){
     if(str.length()<=1){
        return true;
     }
     if(str.charAt(0) != str.charAt(str.length()-1)){
      return false;
     }

     return checkPalindrome(str.substring(1, str.length()-1));
  }
  
  
  /** 
   * Write a recursive method to reverse the order
   * of a given string.
   * @param str
   * @return 
   */
  static String reverseOrder(String str){
      if(str.length() <= 1){//if string is empty or is 1 then it is already in resverse order so return the str
        return str;
      }

      return reverseOrder(str.substring(1)) + str.charAt(0);//removes the first letter then adds it to the end
  }
  
  /**
   * Write a recursive method that will return 
   * a string containing only the characters of a given
   * string but not in another string.
   * 
   * You are not allowed to use the replace or 
   * replaceAll method of the String class.
   * 
   * The returned string must contain the characters 
   * of the given string in the same sequence they
   * appear in the given String.
   * @param given The original string to filter.
   * @param unexpectedCh The string containing characters 
   * to be removed.
   * @return A new string with only the characters from 
   * the given string that are not in unexpectedCh
   */
  static String returnSubstring(String given,
          String unexpectedCh){
     if(given.isEmpty()){ //returns if empty
      return given;
     }
     char char1 = given.charAt(0);//gets the first char in the string
     String char1S = Character.toString(char1);//converts it into a string in order to use  . contains
     if(unexpectedCh.contains(char1S)){//if the unwanted this contains the char then
      return returnSubstring(given.substring(1), unexpectedCh);//it removes the first letter and contiunes
     }else{
      return char1 + returnSubstring(given.substring(1), unexpectedCh);//else it adds it back and contiues
     }
        
  }
  
  /**
   * Perform a recursive binary search to find the 
   * index of a key in a sorted array.
   * If found, return its index. If not, 
   * return -(insertion point+1).
   *
   * @param arr  The sorted array of integers.
   * @param key  The integer value to search for.
   * @param low  The lower bound of the search range.
   * @param high The upper bound of the search range.
   * @return The index of the key if found, 
   * or -(insertion point+1) if not found.
   */
  static int binaryNumSearch(int[] arr, int key, 
    int low, int high) {
    
    if(low>high){//is the -(insertion point +1) because it will always get down to this case if not int here
      return -(low+1);
    }
    int mid = low + (high-low)/2;//gets the middle
    if(arr[mid]==key){//if its the middle return
      return mid;
    }else if (arr[mid]<key){//if its in the highre range set the low to the middle essentially /2
      return binaryNumSearch(arr, key, mid + 1, high);
    }else{
      return binaryNumSearch(arr, key, low, mid -1);//if its in the lower set high to the middle essetnially /2
    }
  }

  /**
   * Write a recursive binary search method to find 
   * the index of a character in a string. If
   * the character appears multiple times, return
   * the index of the one that is first encountered 
   * by binary search.
   * @param str The sorted string to search in.
   * @param searchee The character to find.
   * @param start The starting index of the search range.
   * @param end The ending index of the search range.
   * @return The index of the character if found, else -1. 
   */

  static int binaryCharSearch(
          String str, 
          char searchee, 
          int start, int end){
      if(start > end){//same like char it will get here if its not in the range
        return -1;
      }
      int mid = start + (end-start)/2;//finds the middle of the soreted string
      if(str.charAt(mid)==searchee){//if its in the middle return middle
        return mid;
      }else if (str.charAt(mid)<searchee){//if its in the upper half then set start to the middle
        return binaryCharSearch(str, searchee, mid+1, end);
      }else{
        return binaryCharSearch(str, searchee, start, mid-1);//if its in the lower half then set the end to the middle
      }
  }
}
