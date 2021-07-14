#include <iostream>
#include <bits/stdc++.h>
using namespace std;

//class  Singleton {
//public:
//    static Singleton* getInstance() {
//        if (instance==NULL) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//private:
//    Singleton() {};
//    static Singleton *instance ;
//};
class Solution {
public:
};
class Node {
public:
    int level;
    bool end;
    Node* child[26];
    set<string> words;
//    Node() {
//        level = 0;
//        end = false;
//    }
};
class Trie {
public:
    Node* root;
    Trie() {
        root = new Node();
    }
    void add(string s) {
        Node* u = root;
        for (int i=0;i<s.size();i++) {
            int ch = tolower(s[i])-'a';
            if (!u->child[ch]) u->child[ch] = new Node();
            u = u->child[ch];
            u->level = i+1;
            if (i>=1) {
                u->words.insert(s);
                if (u->words.size() > 3) {
                    u->words.erase(*u->words.rbegin());
                }
            }
        }
        u->end = true;
    }
    vector<vector<string>> query(string query) {
        vector<vector<string>> res;
        Node* u = root;
        for (int i = 0; i < query.size(); ++i) {
            int ch = tolower(query[i])-'a';
            if (u) u = u->child[ch];
            if (i>=1) {
                vector<string> v;
                if (u) for (string s: u->words) {
                    v.push_back(s);
                }
                res.push_back(v);
            }
        }
        return res;
    }
};
vector<vector<string>> searchSuggestions(vector<string> repository, string customerQuery) {
    Trie* trie = new Trie();
    for (auto word: repository) {
        trie->add(word);
    }
    return trie->query(customerQuery);
}
int main() {
//    Singleton *s = Singleton::getInstance();
//    std::cout << s << std::endl;
//    s = Singleton::getInstance();
//    std::cout << s << std::endl;
    Solution *solution = new Solution();
    vector<string> repo = {"bags","baggage","banner","box","cl","cloths","mobile"};
    auto res = searchSuggestions(repo, "clp");
     res = searchSuggestions(repo, "cr");
//    cout << solution->isValid("[()]")<<endl;
//    cout << solution->isValid("[()")<<endl;
//    cout << solution->isValid("([])");
    return 0;
}
