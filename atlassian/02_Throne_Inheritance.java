class ThroneInheritance {

    HashMap<String,List<String>> person;
    Set<String> sad;
    String start;

    public ThroneInheritance(String kingName) {
        
        person = new HashMap();
        sad = new HashSet();

        start = kingName;
        person.put(kingName,new ArrayList<>());

    }
    
    public void birth(String parentName, String childName) {
        
        person.get(parentName).add(childName);
        person.put(childName,new ArrayList<>());

    }
    
    public void death(String name) {
        sad.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        
        return dfs(start);

    }

    private List<String> dfs(String par){

        List<String> list = new ArrayList<>();
        
        if (!sad.contains(par))
            list.add(par);

        for (String s : person.get(par)){
            list.addAll(dfs(s));
        }


        return list;

    }

}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
