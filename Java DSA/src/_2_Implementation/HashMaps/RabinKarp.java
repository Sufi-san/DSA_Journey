package _2_Implementation.HashMaps;

public class RabinKarp {
    public static void main(String[] args) {
        String pattern = "cca";
        String text = "ccaaccaccac";

        // Simple String Matching:
        matchStr(pattern, text);

        System.out.println("\nUsing Karp Rabin: ");
        // Karp Rabin:
        kpMatchStr(pattern, text);
    }

    static void matchStr(String pattern, String text) {
        System.out.println("\nPattern: "+pattern);
        System.out.println("Text: "+text);
        int s = 0, e = pattern.length();
        while(e <= text.length()) {
            boolean match = true;
            for(int i = s, j = 0; i < e; i++, j++) {
                if(pattern.charAt(j) != text.charAt(i)) {
                    match = false;
                    break;
                }
            }
            if(match) System.out.println("Pattern found at index: "+s);
            s++;
            e++;
        }
    }

    static void kpMatchStr(String pattern, String text) {
        int lenPat = pattern.length();
        if(text.length() < lenPat) return;
        double pHash = hash(pattern);
        double tHash = hash(text.substring(0, lenPat));
        for(int i = 0; i <= text.length() - lenPat; i++) {
            if(pHash == tHash && pattern.equals(text.substring(i, i + lenPat)))
                System.out.println("Pattern Found at Index: "+i);
            if(i < text.length() - lenPat)
                tHash = updateHash(tHash, text.charAt(i), text.charAt(i + lenPat), lenPat);
        }
    }

    static int PRIME = 127;

    // The hashing function for initial hash
    static double hash(String str) {
        double hash = 0;
        for(int i = 1; i <= str.length(); i++) {
            hash += str.charAt(i - 1) * Math.pow(PRIME, str.length() - i);
        }
        return hash;
    }

    // Updating the current hash
    static double updateHash(double currHash, char sChar, char eChar, int lenPat) {
        double newHash = (currHash - sChar * Math.pow(PRIME, lenPat - 1)) * PRIME;
        newHash += eChar;
        return newHash;
    }
}
