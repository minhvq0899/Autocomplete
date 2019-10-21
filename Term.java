import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {
    private String query;
    private long weight;

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        if (query == null || weight < 0) {
            // illegal arguments
            throw new IllegalArgumentException("Query must not be null and weight must be positive");
        }

        this.query = query;
        this.weight = weight;
    }

    //
    private static class ReverseWeightOrder implements Comparator<Term> {
        public int compare(Term a, Term b) {
            if (a.weight < b.weight) return 1;
            else if (a.weight > b.weight) return -1;
            else return 0;
        }
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return new ReverseWeightOrder();
    }

    //
    private static class PrefixOrder implements Comparator<Term> {
        private int r;

        public PrefixOrder(int r) {
            this.r = r;
        }

        public int compare(Term a, Term b) {
            String aSub;
            String bSub;
            if (a.query.length() < r) aSub = a.query;
            else aSub = a.query.substring(0, r);
            if (b.query.length() < r) bSub = b.query;
            else bSub = b.query.substring(0, r);
            return aSub.compareTo(bSub);
        }
    }

    // Compares the two terms in lexicographic order,
    // but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0) {
            throw new IllegalArgumentException("r must be positive");
        } else {
            return new PrefixOrder(r);
        }
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return this.query.compareTo(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return Long.toString(weight) + "\t" + this.query;
    }

    // unit testing (required)
    public static void main(String[] args) {
        Term a = new Term("Autocomplete", 5);
        Term b = new Term("Automobile", 7);
        Term c = new Term("Automatic", 10);
        Term[] terms = new Term[4];
        terms[0] = b;
        terms[1] = b;
        terms[2] = a;
        terms[3] = c;

        Comparator<Term> weight = a.byReverseWeightOrder();
        Arrays.sort(terms, weight);
        Term[] minh = terms;
        StdOut.println(terms[0].query + " minh " + terms[1].query + terms[2].query + terms[3].query);
        StdOut.println(minh);
    }

}

