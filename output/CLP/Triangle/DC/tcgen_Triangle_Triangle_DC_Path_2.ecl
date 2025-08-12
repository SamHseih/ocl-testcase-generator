:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Triangle_Triangle_DC_Path_2(Sa,Sb,Sc,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_sideA,Self_sideB,Self_sideC],

%CLG Path Constrints,
(((((((Sa+Sb) #=< Sc) ; ((Sb+Sc) #=< Sa)) ; ((Sa+Sc) #=< Sb)) ; (Sa #=< 0)) ; (Sb #=< 0)) ; (Sc #=< 0)),
Result = 'EdgeErrorException',

%TypeVar Labeling Parts
labeling_int([Self_sideA, Self_sideB, Self_sideC, Sa, Sb, Sc]).
