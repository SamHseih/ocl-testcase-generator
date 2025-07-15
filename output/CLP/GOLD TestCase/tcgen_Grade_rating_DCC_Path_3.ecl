:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

tcgen_Grade_rating_DCC_Path_3(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_number],


%CLG Path Constrints,
(Self_number #>= 0),
(Self_number #=< 100),
(Self_number #> 59),
(Self_number #> 69),
(Self_number #>= 70),
(Self_number #=< 79),
(Result = 'C'),

%TypeVar Labeling Parts
labeling_int([Self_number]).
