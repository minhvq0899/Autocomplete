import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Autocomplete {
    private final Term[] terms; // this is final because this data type is immutable

    // Initializes the data structure
    public Autocomplete(Term[] terms) {
        // Corner cases
        if (terms == null) throw new IllegalArgumentException("Terms is null");

        // Initialize terms
        this.terms = new Term[terms.length];
        for (int i = 0; i < terms.length; i++) {
            this.terms[i] = terms[i];
            if (terms[i] == null) {
                throw new IllegalArgumentException("An element in terms is null");
            }
        }

        // Sort the array in lexicographic order
        Merge.sort(this.terms);
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix is null");
        }

        // create a new term from prefix
        Term pref = new Term(prefix, 0);
        int r = prefix.length();

        // find the first index of the first key in array terms that is equal to prefix
        int first = BinarySearchDeluxe.firstIndexOf(this.terms, pref, Term.byPrefixOrder(r));
        // find the last index of the first key in array terms that is equal to prefix
        int last = BinarySearchDeluxe.lastIndexOf(this.terms, pref, Term.byPrefixOrder(r));

        // Initialize our result
        Term[] result;

        // Copy all the elements in the subarray of terms from first ot last
        // into our result array
        if (first != -1 && last != -1) {
            // initialize our result array
            result = new Term[last - first + 1];
            // Copy
            for (int i = 0; i < result.length; i++) {
                result[i] = this.terms[first + i];
            }
        } else { // if there is no match in terms
            result = new Term[1];
            result[0] = new Term("No Result Found", 0);
        }

        // Sort the matching terms in descending order by weight
        Arrays.sort(result, Term.byReverseWeightOrder());

        return result;
    }


    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix must not be null");
        }

        // create a new term from prefix
        Term pref = new Term(prefix, 0);
        int r = prefix.length();

        // find the first index of the first key in array terms that is equal to prefix
        int first = BinarySearchDeluxe.firstIndexOf(this.terms, pref, Term.byPrefixOrder(r));
        // find the last index of the first key in array terms that is equal to prefix
        int last = BinarySearchDeluxe.lastIndexOf(this.terms, pref, Term.byPrefixOrder(r));

        if (first == -1) return 0;
        else return (last - first + 1);
    }

    // unit testing (required)
    public static void main(String[] args) {
        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        Term[] terms = new Term[n];
        for (int i = 0; i < n; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }

        // read in queries from standard input and print the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            StdOut.printf("%d matches\n", autocomplete.numberOfMatches(prefix));
            for (int i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }

}
