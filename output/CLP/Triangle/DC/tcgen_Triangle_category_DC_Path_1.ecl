:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Triangle_category_DC_Path_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_sideA,Self_sideB,Self_sideC],


%CLG Path Constrints,
(((((((Self_sideA+Self_sideB) #> Self_sideC),
((Self_sideB+Self_sideC) #> Self_sideA)),
((Self_sideA+Self_sideC) #> Self_sideB)),
(Self_sideA #> 0)),
(Self_sideB #> 0)),
(Self_sideC #> 0)),
(Self_sideA #= Self_sideB),
(Self_sideB #= Self_sideC),
(Result = 'Equilateral'),

%TypeVar Labeling Parts
labeling_int([Self_sideA, Self_sideB, Self_sideC]).
