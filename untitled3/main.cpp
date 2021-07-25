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
    int f(vector<int>& a, vector<int>& b) {
        int t = 0;
        for (int i=0;i<a.size();i++) if(a[i]==b[i]) t++;
        return t;
    }
    int maxCompatibilitySum(vector<vector<int>>& students, vector<vector<int>>& mentors) {
        int m = students.size(), n = students[0].size();
        const int N = 22;
        int score[N][N];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                score[i][j] = f(students[i], mentors[j]);
            }
        }
        int a[N];
        for (int i = 0; i < m; ++i) {
            a[i]=i;
        }
        int ans = 0;
        do {
            int sum = 0;
            for (int i=0; i < m; ++i) {
                sum += score[i][a[i]];
            }
            ans = max(ans, sum);
        } while (next_permutation(a, a+m));
        return ans;
    }
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
    solution->maxCompatibilitySum()
//    vector<string> repo = {"bags","baggage","banner","box","cl","cloths","mobile"};
//    auto res = searchSuggestions(repo, "clp");
//     res = searchSuggestions(repo, "cr");
//    cout << solution->isValid("[()]")<<endl;
//    cout << solution->isValid("[()")<<endl;
//    cout << solution->isValid("([])");
    return 0;
}
