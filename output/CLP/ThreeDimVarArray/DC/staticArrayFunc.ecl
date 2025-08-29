:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

%%%%%%%%%%%%%%%%%% Delay Declaration %%%%%%%%%%%%%%%%%%
delay getDimension(Array,_) if var([Array]).
getDimension(Array,Dimension):-
dim(Array,Dim),
length(Dim,Dimension)
.

delay getDimensionSizes(Array,_) if var([Array]).
getDimensionSizes(Array,SizeList):-
dim(Array,SizeList)
.

delay getDimensionSizes(Array,Arg,_) if var([Array,Arg]).
getDimensionSizes(Array,Arg,Size):-
dim(Array,SizeList),
nth1(Arg,SizeList,Size)
.

delay decl_Array(_,DimensionSizes) if nonground([DimensionSizes]).
decl_Array(Array,DimensionSizes):-
dim(Array,DimensionSizes)
.

%Generation Ex. Min=1 ,Max=5  L= [1,2,3,4,5]
delay sequencetoList(Min,Max,_) if  nonground([Min,Max]).
sequencetoList(Min,Max,L):-
( for(I,Min,Max), foreach(I,L) do true )
.

delay getArrayElement(X,Index,_) if (var(X);nonground([Index])).
getArrayElement(X, Index, Ele):-
	arg(Index, X, Ele).
	
delay delay_mod(Input,Integer,_) if  nonground([Input,Integer]).
delay_mod(Input,Integer,Output):-
mod(Input,Integer,Output)
.

%%%%%%%%%%%%%%%%%% Labeling random value %%%%%%%%%%%%%%%%%%
%?-labeling_Arrays(Vars).


labeling_Arrays(Arrays):-
Arrays:: (-32768)..32767,
search(Arrays, 0, first_fail, indomain_random, complete, [])
.

labeling_Array(Array):-
Array #:: -32768..32767,
( foreachelem(Ele, Array) do 
		( var(Ele) ->          % 只有「仍是變數」才 indomain
            indomain(Ele, random)
        ; true )
	)
.

labeling_int(List):-
List #::(-32768)..32767,
search(List, 0, first_fail, indomain_random, complete, [])
.

labeling_Dim(List):-
List #::1..5,
search(List, 0, first_fail, indomain_random, complete, [])
.

%%%%%%%%%%%%%%%%%% Another %%%%%%%%%%%%%%%%%%
%宣告並初始化一個 N 維度的陣列，並為其元素設置值範圍和賦值
new_array(Array,Dimensions) :-
    %創建 N 維度的 Array , 每個元素皆為 _未知
    dim(Array, Dimensions), 
    %為數組中的每個元素設置值的範圍
	Array #:: (-32768)..32767,
    ( foreachelem(Ele, Array) do 
		( var(Ele) ->          % 只有「仍是變數」才 indomain
            indomain(Ele, random)
        ; true )
	).