class Solution {
    public String countOfAtoms(String formula) {
        
        final Stack<Atom> stack = new Stack<>();
        
        final int length = formula.length();
        int index = 0;
        
        while(index < formula.length()) {
            
            int startIndex = index;
            final char ch = formula.charAt(index);
            
            if(Character.isUpperCase(ch)) {
                if(index + 1 < length && Character.isLowerCase(formula.charAt(index + 1))) {
                    index += 1;
                }
                
                final String atom = formula.substring(startIndex, index + 1);
                
                int count = getCount(formula, index);
                
                if(count > 0) {
                    index += String.valueOf(count).length();
                } else {
                    count = 1;
                }
                
                stack.push(new Atom(atom, count));
            } else if(ch == ')') {
                
                int count = getCount(formula, index);

                if(count > 0) {
                    index += String.valueOf(count).length();
                } else {
                    count = 1;
                }
                
                evaluateExpression(stack, count);
            } else {
                stack.push(new Atom(ch + "", 0));
            }
            
            index++;
        }
        
        final Map<String, Integer> map = new TreeMap<>();
        
        while( ! stack.isEmpty()) {
            final Atom atom = stack.pop();
            
            if( ! map.containsKey(atom.name)) {
                map.put(atom.name, atom.count);
            } else {
                final int currentCount = map.get(atom.name);
                map.put(atom.name, atom.count + currentCount);
            }
        }
        
        final StringBuilder sb = new StringBuilder();
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            
            sb.append(entry.getKey());
            if(entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        
        return sb.toString();
    }
    
    private int getCount(String formula, int index) {
        int count = 0;

        while(++index < formula.length() && Character.isDigit(formula.charAt(index))) {
            count = count * 10 + formula.charAt(index) - '0';
        }
        
        return count;
    }
    
    private void evaluateExpression(Stack<Atom> stack, int count) {
        
        // do until we hit an open paren or while stack has atoms
        final LinkedList<Atom> list = new LinkedList<>();
        while( ! stack.isEmpty() && ! stack.peek().name.equals("(")) {
            final Atom atom = stack.pop();
            atom.count *= count;
            list.add(atom);
        }
        
        // pop out the open parentheses
        stack.pop();
        
        // add atoms back on the stack
        while( ! list.isEmpty()) {
            stack.push(list.removeLast());
        }
    }
    
    
    class Atom {
        String name;
        int count;
        
        Atom(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }
}