package codejam.sequences;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by oscar on 7/7/16.
 */
public class Sequences {

    private int lastAnswer;
    private int numOfQueries;
    private int numOfSequences;
    private List<Query> queries;
    private ArrayList<Integer> [] sequences;

    public Sequences(int numOfQueries, int numOfSequences) {
        queries = new ArrayList<>(numOfQueries);
        sequences = (ArrayList<Integer>[]) new ArrayList[numOfSequences];
        for(int i=0; i<numOfSequences; i++) {
            sequences[i] = new ArrayList<>();
        }
        this.numOfQueries = numOfQueries;
        this.numOfSequences = numOfSequences;
        lastAnswer = 0;
    }

    public void addQuery(int type, int x, int y) {
        queries.add(new Query(type, x, y));
    }

    private void executeQuery(Query query) {
        int seqIndex = (query.getX()^lastAnswer)%numOfSequences;

        if(query.getQueryType() == Query.QueryType.ONE) {
            sequences[seqIndex].add(query.getY());
        } else {
            int yModSeqSize = query.getY()%sequences[seqIndex].size();
            int value = sequences[seqIndex].get(yModSeqSize);
            lastAnswer = value;
            System.out.println(lastAnswer);
        }
    }

    public void solve() {
        for(Query query : queries) {
            executeQuery(query);
        }
    }

    private static class Query{
        QueryType queryType;
        int x;
        int y;

        private enum QueryType{
            ONE(1), TWO(2);

            private final int intValue;

            public int getIntValue() {
                return intValue;
            }

            QueryType(int intValue) {
                this.intValue = intValue;
            }
        }

        public Query(int queryType, int x, int y) {
            if(queryType == QueryType.ONE.getIntValue()) {
                this.queryType = QueryType.ONE;
            } else {
                this.queryType = QueryType.TWO;
            }
            this.x = x;
            this.y = y;
        }

        public QueryType getQueryType(){
            return queryType;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(new File("/home/oscar/IdeaProjects/googleinterview/src/codejam/sequences/input.txt"));
        int numOfSequences = in.nextInt();
        int numOfQueries = in.nextInt();
        Sequences solution = new Sequences(numOfQueries, numOfSequences);

        int type, x, y;
        for(int i=0; i<numOfQueries; i++) {
            type = in.nextInt();
            x = in.nextInt();
            y = in.nextInt();
            solution.addQuery(type, x, y);
        }

        solution.solve();
    }
}
