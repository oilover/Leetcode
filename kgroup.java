ListNode tmp = head, ret = null;
        int c = 1;
        while (tmp!=null && tmp.next!=null) {
        	ListNode p = rever(tmp,k);
        	test(p);
        	if (c==1) {
        		ret = p;
        	}
        	c++;
        	System.out.println("nextFirst:"+nextFirst);
        	tmp.next = nextFirst;
        	tmp = nextFirst;
        }
  int c = 1;
//        while (tmp!=null && tmp.next!=null) {
//        	ListNode p = rever(tmp,k);
//        	test(p);
//        	if (c==1) {
//        		ret = p;
//        	}
//        	c++;
//        	System.out.println("nextFirst:"+nextFirst);
//        	tmp.next = nextFirst; //rev(nextFist)
//        	tmp = nextFirst;
//        }
