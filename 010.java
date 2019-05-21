int commonCharacterCount(String s1, String s2) {
    int totalCommonCharacters = 0;
    
    char [] c1 = s1.toCharArray();
    char [] c2 = s2.toCharArray();
    
    char [] smallGroup;
    char [] bigGroup;
    
    Object [] bigGroupI;
    
    if ( c1.length < c2.length ){
        smallGroup = c1;
        bigGroup = c2;
    } else {
        smallGroup = c2;
        bigGroup = c1;
    }
    
    int limitBigGroup = bigGroup.length;
    
    for ( char elementS : smallGroup ){
        for ( int i = 0; i < limitBigGroup; i++ ){
            
            char elementB = bigGroup[ i ];
            
            if ( elementS == elementB ){
                totalCommonCharacters++;
                limitBigGroup--;
                
                bigGroupI = new Integer [ bigGroup.length ];
                    
                for ( int j = 0; j < bigGroup.length; j++ ){
                    char element = bigGroup[ j ];
                    bigGroupI[ j ] = (int) element;
                }

                List container = new ArrayList<>( Arrays.asList( bigGroupI ) );

                container.remove( i );

                bigGroupI = container.toArray();

                bigGroup = new char [ bigGroupI.length ];
                for ( int j = 0; j < bigGroupI.length; j++ ){
                    int element = (Integer) bigGroupI[ j ];
                    bigGroup[ j ] = (char) element;
                }
                
                break;
            }
        }
    }
    
    return totalCommonCharacters;
}
