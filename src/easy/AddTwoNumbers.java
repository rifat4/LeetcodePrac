package easy;

import java.math.BigInteger;

public class AddTwoNumbers {

    //Stringbuilder solution
    //Cost of converting string to int
    //Slow solution to what is possible
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb = new StringBuilder();
        while(l1 != null){
            sb.append(l1.val);
            l1 = l1.next;
        }
        sb.reverse();
        String temp = sb.toString();
        sb.setLength(0);
        while(l2 != null){
            sb.append(l2.val);
            l2 = l2.next;
        }
        sb.reverse();
        String temp2 = sb.toString();
        BigInteger temp3 = new BigInteger(temp).add(new BigInteger(temp2));
        sb = new StringBuilder(temp3.toString());
        sb.reverse();

        ListNode l3 = new ListNode();

        ListNode tempNode = l3;

        for(int i = 0; i < sb.length(); i++){
            tempNode.val = Character.getNumericValue(sb.charAt(i));
            if (i < sb.length() - 1) {
                tempNode.next = new ListNode();
                tempNode = tempNode.next;
            }
        }

        return l3;

    }


    //Without using bigint and without conversions between integers and strings
    public ListNode addTwoNumbersNoConversion(ListNode l1, ListNode l2){
        int carry = 0;
        ListNode head = new ListNode();
        ListNode tail = head;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                tail.val = carry + l1.val + l2.val;
                if(tail.val >= 10){
                    carry = 1;
                    tail.val -= 10;
                } else {
                    carry = 0;
                }
                if(l1.next != null || l2.next != null){
                    tail.next = new ListNode();
                    tail = tail.next;
                }
                l1 = l1.next; l2 = l2.next;
            } else if(l1 != null){
                tail.val = carry + l1.val;
                if(tail.val >= 10){
                    carry = 1;
                    tail.val -= 10;
                } else {
                    carry = 0;
                }
                if(l1.next != null){
                    tail.next = new ListNode();
                    tail = tail.next;
                }
                l1 = l1.next;
            } else if(l2 != null){
                tail.val = carry + l2.val;
                if(tail.val >= 10){
                    carry = 1;
                    tail.val -= 10;
                } else {
                    carry = 0;
                }
                if(l2.next != null){
                    tail.next = new ListNode();
                    tail = tail.next;
                }
                l2 = l2.next;
            }
        }
        if(carry == 1){
            tail.next = new ListNode();
            tail = tail.next;
            tail.val = carry;
        }

        return head;
    }

    public ListNode addtwoNumbersNoConversionInproved(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode tail = head;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum/10;
            sum = sum % 10;

            tail.val = sum;
            if((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || carry != 0){
                tail.next = new ListNode();
                tail = tail.next;
            }


            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return head;

    }

    public AddTwoNumbers(){
        String a = "24993";
        String b = "564";

        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();

        ListNode temp = l1;

        for(int i = 0; i < a.length(); i++){
            temp.val = Character.getNumericValue(a.charAt(i));
            if (i < a.length() - 1) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }

        temp = l2;

        for(int i = 0; i < b.length(); i++){
            temp.val = Character.getNumericValue(b.charAt(i));
            if (i < a.length() - 1) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }


        ListNode l3 = addtwoNumbersNoConversionInproved(l1, l2);

        printList(l3);
    }

    private void printList(ListNode l3){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(l3 != null){
            sb.append(l3.val + ",");
            l3 = l3.next;
        }
        sb.setCharAt(sb.length()-1, ']');
        System.out.println(sb);
    }


    public static void main(String args[]){
        new AddTwoNumbers();
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}






