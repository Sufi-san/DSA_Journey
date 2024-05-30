package _2_Implementation.HuffmanCoding;


public class HuffNode <T> {
    T data;
    int cost;
    HuffNode<T> left;
    HuffNode<T> right;

    HuffNode(T data, int cost) {
        this.data = data;
        this.cost = cost;
    }
}
