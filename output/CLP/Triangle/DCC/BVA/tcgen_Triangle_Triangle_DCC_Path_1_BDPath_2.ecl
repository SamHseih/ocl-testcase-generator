:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Triangle_Triangle_DCC_Path_1_BDPath_2(Self,Sa,Sb,Sc):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_sideA,Self_sideB,Self_sideC],

%CLG Path Constrints,
((Sa+Sb) #> Sc),
((Sb+Sc) #> Sa),
((Sa+Sc) #> Sb),
(Sa #>= 1),
(Sb #= 1),
(Sc #>= 1),
(Self_sideA #= Sa),
(Self_sideB #= Sb),
(Self_sideC #= Sc),

%TypeVar Labeling Parts
labeling_int([Self_sideA, Self_sideB, Self_sideC, Sa, Sb, Sc]).
