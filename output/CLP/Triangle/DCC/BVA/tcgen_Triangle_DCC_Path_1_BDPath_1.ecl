:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Triangle_DCC_Path_1_BDPath_1(Self):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_sideA,Self_sideB,Self_sideC],

%domiain for int Type
[Self_sideA, Self_sideB, Self_sideC]#::(-32768)..32767,
%CLG Path Constrints,
((Self_sideA+Self_sideB) #> Self_sideC),
((Self_sideB+Self_sideC) #> Self_sideA),
((Self_sideA+Self_sideC) #> Self_sideB),
(Self_sideA #> 0),
(Self_sideB #> 0),
(Self_sideC #> 0),

%TypeVar Labeling Parts
labeling_int([Self_sideA, Self_sideB, Self_sideC]).
