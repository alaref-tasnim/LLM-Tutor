package de.hso.aud.ex07;

import java.util.List;

import java.util.ArrayList;

public class SearchTree<K extends Comparable<K>, V> {

    private SearchTreeNode<K, V> root;

    public SearchTree() {
        this(null);
    }

    public SearchTree(SearchTreeNode<K, V> root) {
        this.root = root;
    }

    // For testing only!
    public SearchTreeNode<K, V> getRoot() {
        return this.root;
    }

    public void insert(K key, V value) {
        this.root = SearchTree.insert(this.root, key, value);
    }

    private static <K extends Comparable<K>, V> SearchTreeNode<K, V> insert(SearchTreeNode<K, V> node, K key, V value) {
        if (node == null) {
            return new SearchTreeNode<K, V>(key, value);
        } else {
            int i = key.compareTo(node.getKey());
            // key < node.getKey() --> i < 0
            // key > node.getKey() --> i > 0
            // key.equals(node.getKey()) --> i == 0
            if (i < 0) {
                // key < node.getKey()
                SearchTreeNode<K, V> newLeft = insert(node.getLeft(), key, value);
                node.setLeft(newLeft);
                return node;
            } else if (i > 0) {
                // key > node.getKey()
                SearchTreeNode<K, V> newRight = insert(node.getRight(), key, value);
                node.setRight(newRight);
                return node;
            } else {
                // key.equals(node.getKey())
                node.setValue(value);
                return node;
            }
        }
    }

    public V lookup(K key) {
        return SearchTree.lookup(this.root, key);
    }

    private static <K extends Comparable<K>, V> V lookup(SearchTreeNode<K, V> node, K key) {
        if (node == null) {
            return null;
        } else {
            int i = key.compareTo(node.getKey());
            // key < node.getKey() --> i < 0
            // key > node.getKey() --> i > 0
            // key.equals(node.getKey()) --> i == 0
            if (i < 0) {
                // key < node.getKey()
                return lookup(node.getLeft(), key);
            } else if (i > 0) {
                // key > node.getKey()
                return lookup(node.getRight(), key);
            } else {
                // key.equals(node.getKey())
                return node.getValue();
            }
        }
    }

    public void remove(K key) {
        this.root = SearchTree.remove(this.root, key);
    }

    public Pair<K, V> removeMin() {
        if (this.root == null) {
            return null;
        } else if (this.root.getLeft() == null) {
            SearchTreeNode<K, V> l = this.root;
            this.root = this.root.getRight();
            return new Pair<K, V>(l.getKey(), l.getValue());
        }

        return SearchTree.removeMin(this.root);
    }

    /**
     * Entfernt den Knoten mit dem kleinsten Schlüssel aus dem Baum mit Wurzel node.
     * Der Rückgabewert ist das Paar (k, v) wobei k der kleinste Schlüssel und v der
     * damit assoziierte Wert ist. Beachte: bei einem Aufruf removeMin(node) sind
     * node und node.left nie null.
     */
    private static <K, V> Pair<K, V> removeMin(SearchTreeNode<K, V> node) {
        // @formatter:off
        //
        // Unterscheide folgende beiden Situationen:
        //
        //
        // (a)
        //             node
        //            /    \
        //         left     ?
        //          / \
        //       null right
        //
        //    Ersetze jetzt left durch right und gib Schlüssel/Wert auf left zurück.
        //    right kann dabei null sein oder auch nicht.
        // @formatter:on

        // @formatter:off
        // (b) (left2 != null)
        //             node
        //           /     \
        //         left     ?
        //          / \
        //      left2  ?
        //
        //    Mache dann rekursiv mit left weiter
        //
        // @formatter:on

        return null; // FIXME
    }

    /**
     * Entfernt aus dem (Teil-)baum mit Wurzel node den Knoten mit Schlüssel key.
     * Der Rückgabewert ist die neue Wurzel des (Teil-)baums. Dieser Rückgabewert
     * kann verschieden von node sein, z.B. wenn in node der zu entfernende key steht.
     */
    private static <K extends Comparable<K>, V> SearchTreeNode<K, V> remove(SearchTreeNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int i = key.compareTo(node.getKey());

        // Falls node nicht der zu entfernende Knoten ist, müssen Sie diesen erst
        // finden.

        // @formatter:off
        // Falls node der zu entfernde Knoten ist, sollten Sie folgende Situationen
        //   unterscheiden:
        //
        //
        // (a)
        //             node
        //             /   \
        //           null  null
        // @formatter:on

        // @formatter:off
        // (b) (left != null)
        //             node
        //             /   \
        //           left  null
        // @formatter:on

        // @formatter:off
        // (c) (right != null)
        //             node
        //             /   \
        //           null  right
        // @formatter:on

        // @formatter:off
        // (d) (left != null && right != null)
        //             node
        //             /   \
        //           left  right
        //                 /   \
        //               null   ?
        // @formatter:on

        // @formatter:off
        // (e) (left != null && right != null && left2 != null)
        //             node
        //             /   \
        //           left  right
        //                 /   \
        //              left2   ?
        //
        //    In diesem Fall können Sie removeMin benutzen.
        // @formatter:on
        return null; // FIXME
    }

    public List<Pair<K, V>> inorder() {
        List<Pair<K, V>> list = new ArrayList<Pair<K, V>>();
        SearchTree.inorder(this.root, list);
        return list;
    }

    private static <K, V> void inorder(SearchTreeNode<K, V> node, List<Pair<K, V>> list) {
        if (node != null) {
            inorder(node.getLeft(), list);
            Pair<K, V> p = new Pair<K, V>(node.getKey(), node.getValue());
            list.add(p);
            inorder(node.getRight(), list);
        }
    }

    public List<Pair<K, V>> preorder() {
        List<Pair<K, V>> list = new ArrayList<Pair<K, V>>();
        SearchTree.preorder(this.root, list);
        return list;
    }

    private static <K, V> void preorder(SearchTreeNode<K, V> node, List<Pair<K, V>> list) {
        if (node != null) {
            Pair<K, V> p = new Pair<K, V>(node.getKey(), node.getValue());
            list.add(p);
            preorder(node.getLeft(), list);
            preorder(node.getRight(), list);
        }
    }

    public List<Pair<K, V>> postorder() {
        List<Pair<K, V>> list = new ArrayList<Pair<K, V>>();
        SearchTree.postorder(this.root, list);
        return list;
    }

    private static <K, V> void postorder(SearchTreeNode<K, V> node, List<Pair<K, V>> list) {
        if (node != null) {
            postorder(node.getLeft(), list);
            postorder(node.getRight(), list);
            Pair<K, V> p = new Pair<K, V>(node.getKey(), node.getValue());
            list.add(p);
        }
    }


    private static <K, V> K minimum(SearchTreeNode<K, V> node) {
    if (node == null) {
        return null;
    }

    SearchTreeNode<K, V> current = node;
    SearchTreeNode<K, V> next = null;

    boolean done = false;

    for (int guard = 0; guard < 1000 && !done; guard++) {
        next = current.getLeft();

        if (next == null) {
            done = true;        
        } else {
            current = next;    
        }
    }

        return current.getKey();
    }

    public K minimum() {
        return minimum(this.root);
    }


    public void rotateLeft() {
        SearchTreeNode<K, V> a = this.root;
        if (a == null) {
            return;
        }
        SearchTreeNode<K, V> b = a.getRight();
        if (b == null) {
            return;
        }
        SearchTreeNode<K, V> beta = b.getLeft();
        a.setRight(beta);
        b.setLeft(a);
        this.root = b;
    }

    @Override
    public String toString() {
        return "SearchTree( " + this.root + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof SearchTree) {
            SearchTree that = (SearchTree) other;
            return java.util.Objects.equals(root, that.root);
        } else {
            return false;
        }
    }
}
