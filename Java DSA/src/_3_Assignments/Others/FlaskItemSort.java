package _3_Assignments.Others;

import java.util.*;
public class FlaskItemSort {
    public static void main(String[] args) {
        int flaskCap = 5;
        String[][] initialStates = { // level 10000
                {"P"},
                {"C", "V", "C"},
                {"O", "G", "V", "O", "P"},
                {"C", "P"},
                {"C", "V", "C", "V", "O"},
                {"DB", "P", "G", "G"},
                {"O", "V", "DB", "G", "DB"},
                {"P", "G", "O", "DB", "DB"}
        };
        List<Flask> flaskList = new ArrayList<>();
        for(String[] state: initialStates) {
            flaskList.add(new Flask(state, flaskCap));
        }
        List<String> movesToSolve = new ArrayList<>();
        boolean solvable = solveGame(flaskList, movesToSolve, -1, -1);
        if(!solvable) System.out.println("\nUnable to solve !!");
        System.out.println();
        for(String move: movesToSolve) System.out.println(move);
    }

    private static boolean solveGame(List<Flask> stateList, List<String> moves, int lastSrcID, int lastTargetID) {
        System.out.println(stateList+", Moves Made: "+moves.size());
        List<Flask> unsolved = new ArrayList<>();
        List<Flask> empty = new ArrayList<>();
        for(Flask flask: stateList) {
            if(flask.isEmpty()) {
                empty.add(flask);
                continue;
            }
            if(!flask.isSolved()) unsolved.add(flask);
        }
        if(unsolved.isEmpty()) return true;

        Map<String, List<Flask>> map = new HashMap<>();
        for(Flask flask: unsolved) {
            String topColor = flask.peek();
            List<Flask> mappedList = map.getOrDefault(topColor, new ArrayList<>());
            if(mappedList.isEmpty()) {
                map.put(topColor, mappedList);
                mappedList.addAll(empty);
            }
            mappedList.add(flask);
        }
        List<Flask[]> possibleMoves = new ArrayList<>();
        for(List<Flask> sameTopColorFlasks: map.values()) {
            getValidMoves(sameTopColorFlasks, possibleMoves);
        }
        if(possibleMoves.isEmpty()) return false;

        for(Flask[] move: possibleMoves) {
            Flask sourceFlask = move[0], targetFlask = move[1];
            int timesTransferred = 0;
            if(sourceFlask.getID() == lastTargetID && targetFlask.getID() == lastSrcID) return false;
            while(validMove(sourceFlask, targetFlask)) {
                targetFlask.add(sourceFlask.remove());
                timesTransferred++;
            }
            String sb = "(" + targetFlask.peek() +
                    "), From: Flask " + sourceFlask.getID() +
                    ", To: Flask " + targetFlask.getID() +
                    ", " + timesTransferred + " portions";
            moves.add(sb);
            List<Flask> nextStateList = new ArrayList<>();
            nextStateList.addAll(unsolved);
            nextStateList.addAll(empty);
            boolean isSolved = solveGame(nextStateList, moves, sourceFlask.getID(), targetFlask.getID());
            if(isSolved) return true;
            moves.remove(moves.size() - 1);
            while(timesTransferred != 0) {
                sourceFlask.add(targetFlask.remove());
                timesTransferred--;
            }
        }
        return false;
    }

    private static void getValidMoves(List<Flask> flasks, List<Flask[]> possibleMoves) {
        for(int i = 0; i < flasks.size() - 1; i++) {
            Flask flask1 = flasks.get(i);
            for(int j = i + 1; j < flasks.size(); j++) {
                Flask flask2 = flasks.get(j);
                if(validMove(flask1, flask2)) {
                    possibleMoves.add(new Flask[]{flask1, flask2});
                }
                if(validMove(flask2, flask1)) {
                    possibleMoves.add(new Flask[]{flask2, flask1});
                }
            }
        }
    }

    private static boolean validMove(Flask flask1, Flask flask2) {
        if(flask1.isEmpty()) return false;
        if(flask2.isFull()) return false;
        if(flask2.isEmpty() && flask1.getColorCount() == 1) return false;
        return !(!flask2.isEmpty() && !flask2.peek().equals(flask1.peek()));
    }
}

class Flask {

    private static int idCount = 0;

    final private Stack<String> stack;
    final private Map<String, Integer> colors;
    private boolean solved;
    final private int capacity;
    final private int flaskID;

    public Flask(String[] state, int capacity) {
        this.flaskID = ++idCount;
        this.stack = new Stack<>();
        this.colors = new HashMap<>();
        for(int i = state.length - 1; i > -1; i--) {
            String color = state[i];
            this.stack.push(color);
            this.colors.put(color, colors.getOrDefault(color, 0) + 1);
        }
        this.capacity = capacity;
        this.solved = checkIfSolved();
    }

    public int getID() {return this.flaskID;}

    public int getColorCount() {return this.colors.size();}

    public boolean add(String color) {
        if(this.isFull()) return false;
        this.stack.push(color);
        this.colors.put(color, colors.getOrDefault(color, 0) + 1);
        this.solved = checkIfSolved();
        return true;
    }

    public String remove() {
        if(isSolved()) this.solved = false;
        String color = this.stack.pop();
        int count = this.colors.get(color);
        if(count == 1) this.colors.remove(color);
        else this.colors.put(color, count - 1);
        return color;
    }

    public String peek() {return stack.peek();}

    public boolean isSolved() {return this.solved;}

    public boolean isFull() {return this.stack.size() == this.capacity;}

    public boolean isEmpty() {return this.stack.isEmpty();}

    public int size() {return this.stack.size();}

    private boolean checkIfSolved() {
        return this.stack.size() == capacity && this.colors.size() == 1;
    }

    @Override
    public String toString() {
        return "\nFlask ID: " + this.getID() +
                "\nFlask Contents: " + this.stack.toString() +
                "\nFlask Solved: " + this.isSolved() + "\n";
    }
}
