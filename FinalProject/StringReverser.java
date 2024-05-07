package FinalProject;

public class StringReverser {
    
    // Method to reverse words in the given character array
    public void reverseWords(char[] s) {
        // Reverse the entire string first
        reverse(s, 0, s.length - 1);

        int start = 0; // Starting index for each word
        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                // Reverse each word within the array
                reverse(s, start, i - 1);
                start = i + 1; // Move to the start of the next word
            }
        }
    }

    // Helper method to reverse a portion of the array from start to end
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }

    public static void main(String[] args) {
        // Example 1
        char[] s1 = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        StringReverser reverser = new StringReverser();
        reverser.reverseWords(s1);
        System.out.println("Example 1 Output: " + new String(s1)); // Output: "blue is sky the"

        // Example 2
        char[] s2 = {'a'};
        reverser.reverseWords(s2);
        System.out.println("Example 2 Output: " + new String(s2)); // Output: "a"
    }
}


