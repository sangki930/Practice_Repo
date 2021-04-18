package Programmers.KaKaoBLIND2018.추석트래픽;

import java.util.*;
import java.time.*;
import java.time.format.*;

public class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        
        List<LocalDateTime> timelist = new ArrayList<>();
        List<Log> loglist = new ArrayList<>();
         DateTimeFormatter formatter 
             = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        
        for(String s:lines){
            String tmp[]=s.split(" ");
            LocalDateTime dateTime 
                = LocalDateTime.parse(tmp[0]+" "+tmp[1], formatter);
            tmp[2] = tmp[2].replace("s","");
            long t =(long)((Double.parseDouble(tmp[2])-0.001)*Math.pow(10,9));
            
            loglist.add(new Log(dateTime.minusNanos(t),dateTime));
            timelist.add(dateTime.minusNanos(t));
            timelist.add(dateTime);
           
        }
        
        
        
        for(LocalDateTime ldt: timelist){
            LocalDateTime endldt = ldt.plusSeconds(1L);
            int cnt = (int)loglist.stream()
                .filter(a->(
                    (
                        (a.start.isBefore(endldt))
                        &&
                          (a.start.isAfter(ldt) || a.start.isEqual(ldt)) 
                           ) 
                       )
                        )
                .count();
           
            cnt+=(int)loglist.stream().filter(a->(
                    
                       (
                        (a.end.isBefore(endldt))
                        &&
                          (a.end.isAfter(ldt) || a.end.isEqual(ldt)) 
                           ) 
                       
                       )
                    )
                .count();
             
            cnt-=(int)loglist.stream()
                .filter(a->(
                          (a.start.isAfter(ldt) || a.start.isEqual(ldt)) 
                            &&
                        (a.end.isBefore(endldt)
                       )
                    ))
                .count();
            cnt+=(int)loglist.stream()
                .filter(a->(
                          (a.start.isBefore(ldt)) 
                            &&
                        (a.end.isAfter(endldt)
                       )
                    ))
                .count();
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}

class Log{
    LocalDateTime start;
    LocalDateTime end;
    
    public Log(LocalDateTime start, LocalDateTime end){
        this.start = start;
        this.end = end;
    }
}