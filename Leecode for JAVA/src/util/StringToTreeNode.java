package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import util.Wrapper;


public class StringToTreeNode {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = Wrapper.stringToTreeNode(line);
            Wrapper.prettyPrintTree(root);
        }
    }
}
