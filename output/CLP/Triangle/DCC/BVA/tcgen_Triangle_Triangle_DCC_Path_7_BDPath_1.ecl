:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Triangle_Triangle_DCC_Path_7_BDPath_1(Sa,Sb,Sc,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_sideA,Self_sideB,Self_sideC],

%domiain for int Type
[Self_sideA, Self_sideB, Self_sideC, Sa, Sb, Sc]#::(-32768)..32767,
%CLG Path Constrints,
((Sa+Sb) #> Sc),
((Sb+Sc) #= Sa),
((Sa+Sc) #> Sb),
(Sa #> 0),
(Sb #> 0),
(Sc #> 0),
Result = 'EdgeErrorException',

%TypeVar Labeling Parts
labeling_int([Self_sideA, Self_sideB, Self_sideC, Sa, Sb, Sc]).
