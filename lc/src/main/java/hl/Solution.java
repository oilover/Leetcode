package hl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    Map<String,Node> childs;
    boolean isFolder;
    String path;
    int size;
    Node(String path) {
        childs = new HashMap<>();
        this.path = path;
    }
}
class Result {
    String path;
    int size;

    public Result(String path, int size) {
        this.path = path;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Result{" +
                "path='" + path + '\'' +
                ", size=" + size +
                '}';
    }
}
class Folder {
    private final Node root;
    Folder() {
        root = new Node("/");
        root.isFolder = true;
        path2size = new HashMap<>();
    }
    HashMap<String, Integer> path2size;
    void addFile(String path, int size) throws Exception {
        int addSize = size;
        if (path2size.containsKey(path)) {
            addSize = size - path2size.get(path);
        }
        path2size.put(path, size);
        String[] paths = path.split("/");
        Node cur = root;
        String curPath = "/";
        cur.size += addSize;
        for (String p: paths) {
            if ("".equals(p)) {
                continue;
            }
            if (!curPath.endsWith("/")) {
                curPath += "/";
            }
            cur.isFolder = true;
            curPath += p;
            if (!cur.childs.containsKey(p)) {
                cur.childs.put(p, new Node(curPath));
            }
            cur = cur.childs.get(p);
            cur.size += addSize;
            path2size.put(curPath, cur.size);
        }
        if (cur.isFolder) {
            throw new Exception("This path is a folder");
        }
        cur.isFolder = false;
    }
    int getFolderSize(String path) {
        String[] paths = path.split("/");
        Node cur = root;
        for (String p: paths) {
            if ("".equals(p)) {
                continue;
            }
            if (!cur.childs.containsKey(p)) {
                return 0;
            }
            cur = cur.childs.get(p);
        }
        return cur.size;
    }
    void dfs(Node cur, List<Result> list) {
        if (cur==null || !cur.isFolder) {
            return;
        }
        list.add(new Result(cur.path, cur.size));
        for (Map.Entry<String,Node> entry: cur.childs.entrySet()) {
            Node ch = entry.getValue();
            dfs(ch, list);
        }
    }
    List<Result> getAllFolderSize() {
        List<Result> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    void removeFile(String path) throws Exception {
        addFile(path, 0);
    }

    public static void main(String[] args) throws Exception {
        Folder folder = new Folder();
        folder.addFile("/aa/t", 3);
        folder.addFile("/b", 4);
        List<Result> allFolderSize = folder.getAllFolderSize();
        for(Result r: allFolderSize) {
            System.out.println(r);
        }
    }
}
public class Solution {
    void f(char[] s) {
    }
}
