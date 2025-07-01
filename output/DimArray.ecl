:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

solving(Self,Arg,DimensionSizes,Result):-
 S = [Self],  A = [Arg],  R = [Result],
    dim(Self, [2,2,2]),
    dim(Arg , [2,2,2]),
    dim(Result , [2,2,2]),
	DimensionSizes= [2,2,2],
    % 元素相加約束：Result[I,J,K] = Self[I,J,K] + Arg[I,J,K]
    ( for(I,1,2), for(J,1,2), for(K,1,2),
      param(Self, Arg, Result) do
        Result[I,J,K] #= Self[I,J,K] + Arg[I,J,K]
    ),
	labeling_Arrays([Self,Arg,Result]).

labeling_Arrays(Arrays):-
Arrays:: (-32768)..32767,
search(Arrays, 0, first_fail, indomain_random, complete, []).