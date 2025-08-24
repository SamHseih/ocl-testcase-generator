:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Triangle_Triangle_DCC_Path_5_BDPath_4(Sa,Sb,Sc,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_sideA,Self_sideB,Self_sideC],

%CLG Path Constrints,
((Sa+Sb) #> Sc),
((Sb+Sc) #> Sa),
((Sa+Sc) #=< Sb),
(Sa #>= 1),
(Sb #>= 1),
(Sc #= 1),
Result = 'EdgeErrorException',

%TypeVar Labeling Parts
labeling_int([Self_sideA, Self_sideB, Self_sideC, Sa, Sb, Sc]).
