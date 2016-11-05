/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.dmartínez.t04;

/**
 *
 * @author danx_
 */
public class EDDMartínezT04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(8);
        tree.insert(9);
        tree.insert(7);
        tree.insert(2);
        tree.insert(15);
        tree.insert(18);
        tree.insert(25);
        tree.insert(10);
        System.out.println("Original Tree : ");
        tree.printInOrder(tree.getRoot());
        System.out.println("");
        System.out.println(tree.searchNode(4));
        System.out.println(tree.eNode(2));
        tree.printInOrder(tree.getRoot());
        System.out.println(tree.eNode(4));
        tree.printInOrder(tree.getRoot());
        System.out.println(tree.eNode(10));
        tree.printInOrder(tree.getRoot());
        System.out.println("");
        tree.printPreOrder(tree.getRoot());
        System.out.println("");
        tree.printPostOrder(tree.getRoot());
        System.out.println("");
    }

}
