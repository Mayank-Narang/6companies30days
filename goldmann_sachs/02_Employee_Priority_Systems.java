class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        List<String> highAccessEmp = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (List<String> row: access_times){
            map.putIfAbsent(row.get(0), new ArrayList<>());
            map.get(row.get(0)).add(Integer.parseInt(row.get(1)));
        }
        for(Map.Entry<String, List<Integer>> entry: map.entrySet()){

            if (entry.getValue().size() < 3) continue;

            List<Integer> times = new ArrayList<>();
            times.addAll(entry.getValue());
            Collections.sort(times);
            for(int i=0; i<times.size()-2; i++){
                if(times.get(i)+100>times.get(i+2)){
                    highAccessEmp.add(entry.getKey());
                    break;
                }
            }
        }

    return highAccessEmp;     
    }
}
