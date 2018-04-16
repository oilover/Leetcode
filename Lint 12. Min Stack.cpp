class MinStack {
    private:
        stack<int> S;
        stack<int> minS;
        int m = INT_MAX;
public:
    MinStack() {
        // do intialization if necessary
        m = INT_MAX;
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    void push(int x) {
        // write your code here
        if (x<m) m=x; //m = min(x, m);
        S.push(x);
        minS.push(m);
    }

    /*
     * @return: An integer
     */
    int pop() {
        // write your code here
        
        int t = S.top(); S.pop();
        minS.pop(); if (minS.empty()) m=INT_MAX; else m = minS.top();
        return t;
    }

    /*
     * @return: An integer
     */
    int min() {
        // write your code here
        return minS.top();
    }
};
