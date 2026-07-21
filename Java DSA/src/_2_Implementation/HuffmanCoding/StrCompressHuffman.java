package _2_Implementation.HuffmanCoding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StrCompressHuffman {
    public static void main(String[] args) {

        Map<String, String> encoder = new HashMap<>(), decoder = new HashMap<>();

        // String Compression using Huffman Coding:
        String s = "AEGaGV91@af^$";
        System.out.println("Original String: "+s);

        String bitString = bits(s);
        System.out.println("\nBit Representation without compression: \n"+bitString);
        int spaces = 0;
        for(int i = 0; i < bitString.length(); i++) if(bitString.charAt(i) == ' ') spaces++;
        System.out.println("Length: "+(bitString.length() - spaces));

        String huffBits = huffComp(s, encoder, decoder);
        System.out.println("\nBit Representation with compression: \n"+huffBits);
        spaces = 0;
        for(int i = 0; i < huffBits.length(); i++) if(huffBits.charAt(i) == ' ') spaces++;
        System.out.println("Length: "+(huffBits.length() - spaces));

        // Decoding:
        System.out.println("\nResult after decoding the Compressed Bits: "+huffDecode(huffBits, decoder));
    }

    static String bits(String s) {
        if(s.isEmpty()) return s;
        StringBuilder strB = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            String bitSeq = Integer.toBinaryString(s.charAt(i));
            strB.append("0".repeat(16 - bitSeq.length()));
            // Above line is Same as: for(int j = bitSeq.length(); j < 16; j++) strB.append('0');
            strB.append(bitSeq).append(" ");
        }
        return strB.toString();
    }

    static String huffComp(String s, Map<String, String> encoder, Map<String, String> decoder) {
        if(s.isEmpty()) return s;
        int maxChr = s.charAt(0), minChr = maxChr;
        for(int i = 0; i < s.length(); i++) {
            int chr = s.charAt(i);
            maxChr = Math.max(chr, maxChr);
            minChr = Math.min(chr, minChr);
        }
        int[] freqArr = new int[maxChr - minChr + 1];
        for(int i = 0; i < s.length(); i++) freqArr[(int) s.charAt(i) -  minChr]++;
        Comparator<HuffNode<String>> huffComparator = Comparator.comparingInt(o -> o.cost);
        /*
            Above line is short for:
            Comparator<HuffNode<String>> huffComparator = new Comparator<HuffNode<String>> {
                @Override
                public int compare(HuffCode<String> o1, HuffCode<String> o2) {
                    return Integer.compare(o1.cost, o2.cost);
                }
            }

         */
        PriorityQueue<HuffNode<String>> heap = new PriorityQueue<>(huffComparator);
        for(int i = 0; i < freqArr.length; i++) {
            if(freqArr[i] <= 0) continue;
            String data = Character.toString((char)(i + minChr));
            int cost = freqArr[i];
            heap.add(new HuffNode<>(data, cost));
        }
        while(heap.size() > 1) {
            HuffNode<String> a = heap.poll(), b = heap.poll();
            if(b == null) break;
            HuffNode<String> newNode = new HuffNode<>("", a.cost + b.cost);
            newNode.left = a;
            newNode.right = b;
            heap.add(newNode);
        }
        getCodes(heap.poll(), encoder, decoder, new StringBuilder());
        return huffEncode(s, encoder);
    }

    static void getCodes(HuffNode<String> node, Map<String, String> encoder, Map<String, String> decoder, StringBuilder codes) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            String code = codes.toString();
            encoder.put(node.data, code);
            decoder.put(code, node.data);
        }
        codes.append("0");
        getCodes(node.left, encoder, decoder, codes);
        codes.deleteCharAt(codes.length() - 1);
        codes.append("1");
        getCodes(node.right, encoder, decoder, codes);
        codes.deleteCharAt(codes.length() - 1);
    }

    static String huffEncode(String s, Map<String, String> encoder) {
        StringBuilder code = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            String data = Character.toString(s.charAt(i));
            code.append(encoder.get(data)).append(" ");
        }
        return code.toString();
    }

    static String huffDecode(String huffBits, Map<String, String> decoder) {
        StringBuilder strB = new StringBuilder(), strB2 = new StringBuilder();
        for(int i = 0; i < huffBits.length(); i++) {
            char chr = huffBits.charAt(i);
            if(chr == ' ') continue;
            strB2.append(chr);
            if(decoder.containsKey(strB2.toString())) {
                strB.append(decoder.get(strB2.toString()));
                strB2.delete(0, strB2.length());
            }
        }
        return strB.toString();
    }
}


