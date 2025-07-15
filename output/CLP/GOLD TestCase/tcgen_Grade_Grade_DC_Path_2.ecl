:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

tcgen_Grade_Grade_DC_Path_2(Self,Score):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_number],

%CLG Path Constrints,
((Self_number #>= 0),
(Self_number #=< 100)),
((Score #>= 0),
(Score #=< 100)),
((Self_number #= Score),
(Score_pre #= Score)),

%TypeVar Labeling Parts
labeling_int([Self_number, Score]).
