:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

tcgen_Grade_Grade_DC_Path_1(Score,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_number],

%CLG Path Constrints,
((Score #< 0) ; (Score #> 100)),
Result = 'Exception',

%TypeVar Labeling Parts
labeling_int([Self_number, Score]).
