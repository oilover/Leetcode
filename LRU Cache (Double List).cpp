#define prt(k) cout<<#k" = "<<k<<endl
class Node {
public:
    Node *pre, *next;
    int key, val;
    Node(int key, int val): key(key),val(val),pre(NULL),next(NULL) { prt(this->key); }
};
class List {
public:
    Node *head, *tail;
public:
    List() {
        head = tail = NULL;
    }
    void insert(Node *p) {  // p is not null, same below
        if (tail==NULL) {
            head = tail = p; return;
        }
        if (tail!=NULL) tail->next = p;
        p->pre = tail;
        tail = p;
    }
    void insertFront(Node *p) { 
        if (p==head) {
            return;
        }
        if (head==NULL) {
            head = tail = p;
            return;
        }
        p->pre = NULL;
        p->next = head;
        if (head) head->pre = p;
        head = p;
        
    }
    void moveToFront(Node *p) {
        if (p==head) {
            return;
        }
        if (p==tail) {
            tail = tail->pre;
        }
        if (p->next) p->next->pre = p->pre;
        if (p->pre) p->pre->next = p->next;
        insertFront(p);
    }
    int remove() {        
        assert(tail!=NULL);
        int ret = tail->key;
        // prt(ret);
        if (tail->pre != NULL) {
            // tail->pre->next = NULL;
            tail = tail->pre;
            tail->next = NULL;
        }
        return ret;
    }
    void out() {
        Node *p = head;
    }
};
class LRUCache {
    List l;
    unordered_map<int, Node*> address;
    int capacity;
public:
    LRUCache(int capacity) : capacity(capacity) {
        address.clear();
        l = List();        
    }
    
    int get(int key) {
        // cout<<"get "<<key<<" | "<<endl;
        prt(l.tail);
        if (address.count(key) == 0) return -1;
        Node *p = address[key];
        l.moveToFront(p);
        return p->val;
    }
    
    void put(int key, int value) {
        // cout<<"put "<<key<<endl;
        // prt(l.tail);
        if (address.count(key) == 0) {
            Node *p = new Node(key, value);
            l.insertFront(p);
            address[key] = p;
            if (address.size() > capacity) {
                int tmp = l.remove();
                cout<<"erase " << tmp<<endl;
                address.erase(tmp);
            }
            return;
        }
        Node *p = address[key];
        p->val = value;
        assert(p!=NULL);
        l.moveToFront(p);
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
