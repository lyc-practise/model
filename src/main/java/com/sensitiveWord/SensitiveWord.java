package com.sensitiveWord;

import java.util.Map;
import java.util.Set;

// 敏感词库
public class SensitiveWord {

    private Set<String> sourceSet;
    private Map sourceTree;
    private static final Integer notEnd = 0;
    private static final Integer end = 1;
    private static final Integer both = 2;
    private static final String flag = "isEnd";


    public SensitiveWord(Set<String> sourceSet){
        this.sourceSet = sourceSet;
        appendSourceTree(sourceSet);

    }

    public void clear(){
        sourceTree.clear();
    }

    public void appendSensitiveWord(Set<String> appendSourceSet){
        appendSourceTree(appendSourceSet);
    }

    private void appendSourceTree(Set<String> sourceSet){
        if(sourceSet == null || sourceSet.isEmpty()){  return; }

    }




    enum State{
        notEnd(0),
        end(1),
        both(2);
        State(int state){
            this.state = state;
        }
        int state;
        public static State getState(Integer state){
            if(state == null) { return null;}
            for(State s : State.values()){
                if(state.equals(s.state)){
                    return s;
                }
            }
            return null;
        }

        public static boolean isNotEnd(Integer state){
            State stateEnum;
            return (stateEnum = getState(state)) != null && stateEnum == notEnd;
        }

        public static boolean isEnd(Integer state){
            State stateEnum;
            return (stateEnum = getState(state)) != null && stateEnum == end;
        }

        public static boolean isBoth(Integer state){
            State stateEnum;
            return (stateEnum = getState(state)) != null && stateEnum == both;
        }
    }

}
